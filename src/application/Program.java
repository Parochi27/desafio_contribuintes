package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double impostoSobreSalario, deducaoFinal;
		
		System.out.print("Renda anual com salário: ");
		double rendaAnualSalario = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		double rendaAnualServicos = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		double rendaAnualCapital = sc.nextDouble();
		System.out.print("Gastos médicos: ");
		double gastosMedicos = sc.nextDouble();
		System.out.print("Gastos educacionais: ");
		double gastosEducacionais = sc.nextDouble();
		
		double rendaMensalSalario = rendaAnualSalario / 12;
		if ( rendaMensalSalario < 3_000) {
			impostoSobreSalario = 0;
		}
		else if (rendaMensalSalario >= 3_000 && rendaMensalSalario < 5_000){
			impostoSobreSalario = rendaAnualSalario * 0.10;
		}
		else {
			impostoSobreSalario = rendaAnualSalario * 0.20;
		}
		
		double impostoSobreServicos = rendaAnualServicos * 0.15;
		double impostoSobreCapital = rendaAnualCapital * 0.20;
		double impostoBruto = impostoSobreCapital + impostoSobreSalario + impostoSobreServicos;
		
		double gastosDedutiveis = gastosEducacionais + gastosMedicos;
		double maximoDedutivel = impostoBruto * 0.30;
		
		if (gastosDedutiveis <= maximoDedutivel) {
			deducaoFinal = gastosDedutiveis;
		}
		else {
			deducaoFinal = maximoDedutivel;
		}	
		
		System.out.println();
		System.out.println("RELATÓRIO DE IMPOSTO DE RENDA");
		
		System.out.println();
		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f\n", impostoSobreSalario);
		System.out.printf("Imposto sobre serviços: %.2f\n", impostoSobreServicos);
		System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoSobreCapital);
		
		System.out.println();
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f\n", gastosDedutiveis);
		
		System.out.println();
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
		System.out.printf("Abatimento: %.2f\n", deducaoFinal);
		System.out.printf("Imposto devido: %.2f\n", impostoBruto - deducaoFinal);
		

		sc.close();
		
	}
	
}
