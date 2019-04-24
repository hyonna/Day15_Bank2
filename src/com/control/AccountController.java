package com.control;

import java.util.Scanner;

import com.account.AccountService;
import com.ti.TranService;
import com.view.View;

public class AccountController {

	private Scanner sc;
	private AccountService as;
	private View view;
	private TranService ts;

	public AccountController() {

		sc = new Scanner(System.in);
		as = new AccountService();
		view = new View();
		ts = new TranService();

	}

	public void start() {

		String message = null;
		boolean check = true;
		while (check) {

			System.out.println("1. 계좌개설");
			System.out.println("2. 입      금");
			System.out.println("3. 출      금");
			System.out.println("4. 종      료");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				message = as.insert();
				view.view(message);
				break;

			case 2:

				message = ts.tran(0);
				view.view(message);
				break;

			case 3:

				message = ts.tran(1);
				view.view(message);
				break;

			default:
				check = !check;
			}

		}

	}

}
