package com.app.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BankTransactionImpl implements IBankTransaction {

	File file = new File("D:\\iNeuron\\Projects\\CoreJavaAtmApp\\src\\com\\app\\database\\customerDatabase.txt");
	Scanner scanner = new Scanner(System.in);
	HashMap<String, Object> transaction = new HashMap<String, Object>();

	@Override
	public boolean validateUser(String custId, String password, User user) throws IOException, Exception {

		try {
			if (!file.exists())
				System.out.println("Customer Database does'nt exist");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			if (line != null) {
				if (line.equalsIgnoreCase(custId)) {
					line = br.readLine();
					if (line.equalsIgnoreCase(password)) {
						line = br.readLine();
						user.getAccount().setBalance(Double.parseDouble(line));
						return true;
					} else {
						System.out.print("# Invalid Password");
						return false;
					}
				} else {
					System.out.print("# Invalid Credentials");
					return false;
				}
			} else {
				System.out.println("System Error. Try Again");
				return false;
			}
		} catch (IOException e) {
			throw e;
		}
	}

	@Override
	public void transferMoney(User user, double amt, String accNo) throws IOException, Exception {
		Double currentBal = null;
		String custId = user.getCustId();
		String custPass = user.getCustPass();
		int flag = 0;
		Date currDate = new Date();
		Transaction trans = new Transaction();
		try {
			if (!file.exists())
				System.out.println("Customer Database does'nt exist");
			// Reading the file and updating balance
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			if (line.equals(custId)) {
				line = reader.readLine();
				if (line.equals(custPass)) {
					line = reader.readLine();
					currentBal = Double.parseDouble(line);
					if (amt > currentBal) {
						System.out.println("# Insufficient balance in your A/C. Cannot process your request #");
					} else {
						flag = 1;
						currentBal = currentBal - amt;
						System.out.println("Sum of " + amt + " Transferred Succesfully to Account " + accNo);
						System.out.println("Your Current Balance is :: " + currentBal);
						trans.settId(1);
						trans.setTransAmt(amt);
						trans.setTransDate(currDate);
						transaction.put("transferred", trans);
					}
				}
			} else {
				System.out.println("Enter Valid Credentials");
			}
			// Writing new balance to the file
			if (flag == 1) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				line = br.readLine();
				sb.append(line);
				sb.append("\n");
				if (line != null) {
					line = br.readLine();
					sb.append(line);
					sb.append("\n");
					br.readLine();
					sb.append(currentBal);
				}
				FileWriter fw = new FileWriter(file, false);
				fw.write(sb.toString());
				fw.close();
				br.close();
			}
			reader.close();
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void withdrawMoney(User user, double amt) throws IOException, Exception {
		Double currentBal = null;
		String custId = user.getCustId();
		String custPass = user.getCustPass();
		Date currDate = new Date();
		Transaction trans = new Transaction();
		int flag = 0;
		try {
			if (!file.exists())
				System.out.println("Customer Database does'nt exist");
			// Reading the file and updating balance
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			if (line.equals(custId)) {
				line = reader.readLine();
				if (line.equals(custPass)) {
					line = reader.readLine();
					currentBal = Double.parseDouble(line);
					if (amt > currentBal) {
						System.out.println("# Insufficient balance in your A/C. Cannot process your request #");
					} else {
						flag = 1;
						currentBal = currentBal - amt;
						System.out.println("Sum of " + amt + " Withdrawn Succesfully");
						System.out.println("Your Current Balance is :: " + currentBal);
						trans.settId(2);
						trans.setTransAmt(amt);
						trans.setTransDate(currDate);
						transaction.put("withdrawan", trans);
					}
				}
			} else {
				System.out.println("Enter Valid Credentials");
			}
			// Writing new balance to the file
			if (flag == 1) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				line = br.readLine();
				sb.append(line);
				sb.append("\n");
				if (line != null) {
					line = br.readLine();
					sb.append(line);
					sb.append("\n");
					br.readLine();
					sb.append(currentBal);
				}
				FileWriter fw = new FileWriter(file, false);
				fw.write(sb.toString());
				fw.close();
				br.close();
			}
			reader.close();
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void depositMoney(User user, double amt) throws IOException, Exception {
		Double currentBal = null;
		String custId = user.getCustId();
		String custPass = user.getCustPass();
		int flag = 0;
		Date currDate = new Date();
		Transaction trans = new Transaction();
		try {
			if (!file.exists())
				System.out.println("Customer Database does'nt exist");
			// Reading the file and updating balance
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			if (line.equalsIgnoreCase(custId)) {
				line = reader.readLine();
				if (line.equalsIgnoreCase(custPass)) {
					line = reader.readLine();
					currentBal = Double.parseDouble(line);
					if (amt > 25000) {
						System.out.println(" # You Cannot Deposit more than 25000 at a time. Try Again #");
					} else {
						currentBal = currentBal + amt;
						flag = 1;
						System.out.println("Sum of " + amt + " Deposited Succesfully");
						System.out.println("Your Current Balance is :: " + currentBal);
						trans.settId(3);
						trans.setTransAmt(amt);
						trans.setTransDate(currDate);
						transaction.put("deposited", trans);
					}
				}
			} else {
				System.out.println("Enter Valid Credentials");
			}
			// Writing new balance to the file
			if (flag == 1) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				line = br.readLine();
				sb.append(line);
				sb.append("\n");
				if (line != null) {
					line = br.readLine();
					sb.append(line);
					sb.append("\n");
					br.readLine();
					sb.append(currentBal);
				}
				FileWriter fw = new FileWriter(file, false);
				fw.write(sb.toString());
				fw.close();
				br.close();
			}
			reader.close();
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void balanceInquiry() throws IOException, Exception {
		Double balance = null;
		try {
			if (!file.exists())
				System.out.println("Customer Database does'nt exist");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String accId = reader.readLine();
			if (accId != null) {
				String accPass = reader.readLine();
				if (accPass != null) {
					balance = Double.parseDouble(reader.readLine());
					System.out.println("Your Current A/C Balance is :: " + balance);
				}
			} else {
				System.out.println("System Error. Try Again");
			}
			reader.close();
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void pinChange(User user, String oldPin) throws Exception {

		try {
			if (!file.exists())
				System.out.println("Customer Database does'nt exist");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			sb.append(line);
			sb.append("\n");
			if (line != null) {
				line = reader.readLine();
				if (line.equals(oldPin)) {
					System.out.print("Enter New Pin :: ");
					String newPin = scanner.next();
					sb.append(newPin);
					sb.append("\n");
					line = reader.readLine();
					sb.append(line);
					sb.append("\n");
					FileWriter fw = new FileWriter(file);
					fw.write(sb.toString());
					fw.close();
					System.out.println("Pin Updated Successfully");
				} else {
					System.out.println("# Enter valid Pin #");
				}
			} else {
				System.out.println("System Error. Try Again.");
			}
			reader.close();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void transactionHistory() {

		Set s1 = transaction.entrySet();
		Iterator itr = s1.iterator();
		System.out.println("\nYour Transaction History");
		System.out.println("============================");

		while (itr.hasNext()) {
			Map.Entry m1 = (Map.Entry) itr.next();
			String key = (String) m1.getKey();
			Transaction t1 = (Transaction) m1.getValue();
			System.out.println("Rs." + t1.getTransAmt() + " " + key + " on " + t1.getTransDate() + " ");
		}
	}

}
