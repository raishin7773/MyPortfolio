package com.raishin.service.memo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.raishin.entity.MemoEntity;
import com.raishin.form.MemoForm;
import com.raishin.repository.MemoRepository;

/**
 * メモ画面用サービス
 */
@Service
@Transactional(readOnly = true)
public class MemoService {

  @Autowired
  MemoRepository memoRepository;

  /**
   * 初期表示用メソッド
   * @param form
   * @throws Exception
   */
  public void initView(MemoForm form) throws Exception{
    MemoEntity memoEntity = memoRepository.findById(0);
    if (memoEntity == null) return;
    form.setMemo(memoEntity.getMemo());
  }

  /**
   * メモ更新用メソッド
   * @param form
   * @throws Exception
   */
  @Transactional(readOnly = false)
  public void update(MemoForm form) throws Exception{
    MemoEntity memoEntity = memoRepository.findById(0);
    if (memoEntity == null) memoEntity = new MemoEntity();
    memoEntity.setMemo(form.getMemo());
    memoRepository.save(memoEntity);
  }
}
