package com.raishin.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import com.raishin.entity.DeckEntity;
import com.raishin.form.DeckForm;
import com.raishin.repository.DeckRepository;

@Service
@Transactional(readOnly = true)
public class DeckService {

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    ResourceLoader resourceLoader;

    public List<DeckEntity> getAll() {
        return deckRepository.findAllSort();
    }

    @Transactional(readOnly = false)
    public void deckDelete(DeckForm form) throws Exception {
        if (form.getId() != null) {
            deckRepository.deleteById(form.getId());
        }
    }

    @Transactional(readOnly = false)
    public void deckUpdate(DeckForm form) throws Exception {
        DeckEntity deckEntity = new DeckEntity();
        if (StringUtils.isEmpty(form.getId())) throw new Exception();
        deckEntity.setId(form.getId());
        deckEntity.setDeckname(form.getDeckName());
        deckEntity.setWin(form.getWin());
        deckEntity.setDraw(form.getDraw());
        deckEntity.setLose(form.getLose());
        deckEntity.setCreate_Date(new Date(System.currentTimeMillis()));
        deckEntity.setUpdate_Date(new Date(System.currentTimeMillis()));
        deckRepository.save(deckEntity);
    }

    @Transactional(readOnly = false)
    public void deckInsert(DeckForm form) throws Exception {
        DeckEntity deckEntity = new DeckEntity();
//    deckEntity.setId(form.getId());
        deckEntity.setDeckname(form.getDeckName());
        deckEntity.setWin(form.getWin());
        deckEntity.setDraw(form.getDraw());
        deckEntity.setLose(form.getLose());
        deckEntity.setCreate_Date(new Date(System.currentTimeMillis()));
        deckEntity.setUpdate_Date(new Date(System.currentTimeMillis()));
        deckRepository.save(deckEntity);
    }

    public void initView(DeckForm form, Model model) throws Exception {
        Random random = new Random();
        List<String> decknameList = new ArrayList<>();
        List<String> backColorList = new ArrayList<>();
        List<Integer> duelNumberList = new ArrayList<>();
        List<DeckEntity> entityList = deckRepository.findAllSort();
        entityList.stream().forEach(x -> decknameList.add(x.getDeckname()));
        entityList.stream().forEach(x -> duelNumberList.add(x.getWin() + x.getLose() + x.getDraw()));
        entityList.stream().forEach(x -> backColorList.add("rgb(" + random.nextInt(256) + ", "
                + random.nextInt(256) + ", " + random.nextInt(256) + ")"));

        model.addAttribute("backColorList", backColorList);
        model.addAttribute("decknameList", decknameList);
        model.addAttribute("duelNumberList", duelNumberList);
        model.addAttribute("TopFiveNameList",
                decknameList.stream().limit(5).collect(Collectors.toList()));
        model.addAttribute("TopFiveNumberList",
                duelNumberList.stream().limit(5).collect(Collectors.toList()));
        form.setDeckList(entityList);
    }

    public byte[] createPdf() throws Exception {
        List<DeckEntity> entityList = deckRepository.findAllSort();

        JRDataSource dataSource = new JRBeanCollectionDataSource(entityList);

        Map<String, Object> params = new HashMap<String, Object>();

        //jrxmlファイルをコンパイルする。
        URL url = resourceLoader.getResource("classpath:static/jasper/deckReport.jrxml").getURL();

        InputStream is = url.openStream();
        //コンパイル実行
        JasperReport jasperReport = JasperCompileManager.compileReport(is);

        JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, null, dataSource);

        return JasperExportManager.exportReportToPdf(jasperprint);

    }
}
