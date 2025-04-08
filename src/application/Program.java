package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		List<TaxPayer> taxPayers = new ArrayList<>();
		
		System.out.println();
		for (int i = 1; i <= n; i++) {
			System.out.println();
			
			System.out.println("Digite os dados do " + i + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthExpendings = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationExpendings = sc.nextDouble();
			taxPayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthExpendings, educationExpendings));
		}

		int i = 1;
		for (TaxPayer tp : taxPayers) {
			System.out.println();
			System.out.println("Resumo do " + i + "o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f\n", tp.grossTax());
			System.out.printf("Abatimento: %.2f\n", tp.taxRebate());
			System.out.printf("Imposto devido: %.2f\n", tp.netTax());
			i++;
		}
			

		sc.close();
		
	}
	
}
