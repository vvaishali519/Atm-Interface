package com.app.main;

import java.util.Scanner;

import com.app.core.Account;
import com.app.core.BankTransactionImpl;
import com.app.core.User;

public class Atm {

	private static Scanner scanner;
	private static String custId = null;
	private static String custPass = null;
	private static User user = null;
	private static double withdrwalAmt;
	private static double depositAmt;
	private static double transferAmt;
	private static String accNo;
	private static String oldPin;
	private static String newPin;
	private static BankTransactionImpl bankImpl = new BankTransactionImpl();

	public static void main(String[] args) {

		System.out.println("\t\t\tWelcome to Bank of India");
		System.out.println("\t\t=========================================");
		System.out.println();
		System.out.println("New Account \"vaishali@123\" created succesfully");
		System.out.println();
		scanner = new Scanner(System.in);
		System.out.print("Enter Customer Id : ");
		custId = scanner.next();
		System.out.print("Enter PIN : ");
		custPass = scanner.next();
		boolean validateUser = false;
		try {
			Account account = new Account(1000, null);
			user = new User(custId, custPass, account);
			validateUser = bankImpl.validateUser(custId, custPass, user);
			if (validateUser) {
				selectAccType();
				selectMenu();
			} else {
				System.out.println(" Try Again #");
				System.out.print("\nEnter Customer Id : ");
				custId = scanner.next();
				System.out.print("Enter PIN : ");
				custPass = scanner.next();
				validateUser = bankImpl.validateUser(custId, custPass, user);
				user = new User(custId, custPass, account);
				if (validateUser) {
					selectAccType();
					selectMenu();
				}
				else {
					System.out.println(" # Login Attempts Exceded , Try Later #");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception Occured " + e + " Try Again Later");
		}
	}

	public static void selectMenu() {

		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("Please select option ");
			System.out.println("=======================");
			System.out.println("1. Fund Transfer\t\t 2. Withdraw Money");
			System.out.println("3. Deposit Money\t\t 4. Pin Change");
			System.out.println("5. Balance Inquiry\t\t 6. Transaction History");
			System.out.println("7. Exit");
			System.out.print("\nEnter Choice :: ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				fundTransfer();
				break;
			case 2:
				withdrawMoney();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				pinChange();
				break;
			case 5:
				balanceInquiry();
				break;
			case 6:
				bankImpl.transactionHistory();
				break;
			case 7:
				System.out.println();
				System.out.println("              Thankyou for using Bank of India Atm Services             ");
				System.out.println("             ==================================================             ");
				flag = false;
				break;
			default:
				System.out.println("# Invalid option selected. Try Again #");
				selectMenu();
				break;
			}
		}
	}

	public static void selectAccType() {
		System.out.println();
		System.out.println("Please select your account type ");
		System.out.println("==================================");
		System.out.println("1. Savings");
		System.out.println("2. Current");
		System.out.print("Enter Choice :: ");
		int choice = scanner.nextInt();
		if (choice == 1) {
			user.getAccount().setAccType("Savings");
		} else {
			user.getAccount().setAccType("Current");
		}
	}

	public static void fundTransfer() {
		System.out.print("\nEnter Amount :: ");
		transferAmt = scanner.nextDouble();
		try {
			System.out.print("Enter Reciever's Account Number :: ");
			accNo = scanner.next();
			bankImpl.transferMoney(user, transferAmt, accNo);
		} catch (Exception e) {
			System.out.println("Exception Occured " + e + " Try Again Later");
		}
	}

	public static void withdrawMoney() {
		System.out.print("\nEnter Amount :: ");
		withdrwalAmt = scanner.nextDouble();
		try {
			bankImpl.withdrawMoney(user, withdrwalAmt);
		} catch (Exception e) {
			System.out.println("Exception Occured " + e + " Try Again Later");
		}
	}

	public static void depositMoney() {
		System.out.print("\nEnter Amount :: ");
		depositAmt = scanner.nextDouble();
		try {
			bankImpl.depositMoney(user, depositAmt);
		} catch (Exception e) {
			System.out.println("Exception Occured " + e + " Try Again Later");
		}
	}

	public static void pinChange() {
		System.out.print("Enter Old Pin :: ");
		oldPin = scanner.next();
		try {
			bankImpl.pinChange(user, oldPin);
		} catch (Exception e) {
			System.out.println("Exception Occured " + e + " Try Again Later");
		}
	}

	public static void balanceInquiry() {
		try {
			bankImpl.balanceInquiry();
		} catch (Exception e) {
			System.out.println("Exception Occured " + e + " Try Again Later");
		}
	}

}
