package com.mitsubishi.demo.common.util;

import org.springframework.ui.Model;

public class CssUtil {

	public static void setButtonCss(Model model, String flag) {

		// 新規登録ボタン表示、更新・削除ボタン非表示
		if ("Regist".equals(flag)) {

			model.addAttribute("doRegistButtonCss", "width: 150px; display: ;");
			model.addAttribute("doUpdateButtonCss", "width: 150px; display: none;");
			model.addAttribute("doDeleteButtonCss", "width: 150px; display: none;");

			// 新規登録ボタン非表示、更新・削除ボタン表示
		} else {

			model.addAttribute("doRegistButtonCss", "width: 150px; display: none;");
			model.addAttribute("doUpdateButtonCss", "width: 150px; display: ;");
			model.addAttribute("doDeleteButtonCss", "width: 150px; display: ;");
		}
	}
}
