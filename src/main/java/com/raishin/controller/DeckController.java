package com.raishin.controller;

import com.raishin.entity.DeckEntity;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.raishin.excel.DeckExcelBuilder;
import com.raishin.form.DeckForm;
import com.raishin.repository.DeckRepository;
import com.raishin.service.DeckService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有デッキ一覧コントローラー
 */
@Controller
public class DeckController {

    // @Autowired
    // DeckMapper mapper;

    @Autowired
    DeckRepository deckRepository;

    @Autowired
    DeckService deckService;


    /**
     * 初期表示メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/deck/list")
    public String index(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
                        Model model) throws Exception {
        deckService.initView(form, model);
        return "deck/starter";
    }

    /**
     * デッキ削除メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/deck/delete")
    public String delete(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
                         Model model) throws Exception {
        deckService.deckDelete(form);
        model.addAttribute("message", "削除しました");
        deckService.initView(form, model);
        return "deck/starter";
    }

    /**
     * デッキ更新メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/deck/update")
    public String update(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
                         Model model) throws Exception {
        deckService.deckUpdate(form);
        model.addAttribute("message", "更新しました");
        deckService.initView(form, model);
        return "deck/starter";
    }

    /**
     * デッキ新規作成メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/deck/insert")
    public String insert(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
                         Model model) throws Exception {
        deckService.deckInsert(form);
        model.addAttribute("message", "更新しました");
        deckService.initView(form, model);
        return "deck/starter";
    }

    /**
     * 帳票作成メソッド
     * @param form
     * @param result
     * @param model
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/deck/createPdf")
    public void createPdf(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
                          Model model, HttpServletResponse response) throws Exception {
        byte[] b = deckService.createPdf();
        InputStream is = new ByteArrayInputStream(b);
        IOUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
    }

    /**
     * エクセル出力メソッド
     * @param form
     * @param result
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/portfolio/deck/excel")
    public ModelAndView excel(@ModelAttribute("deckForm") DeckForm form, BindingResult result,
                              Model model) throws Exception {
        List<DeckEntity> deckEntityList = deckService.getAll();
        Map map = new HashMap<String, List<DeckEntity>>();
        map.put("deckList", deckEntityList);
        ModelAndView mav = new ModelAndView(new DeckExcelBuilder(), map);
        mav.addObject("fileName", "デッキ一覧" + ".xls");
        return mav;
    }
}
