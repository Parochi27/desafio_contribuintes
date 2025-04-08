package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthExpending;
	private Double educationExpending;
	
	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthExpending,
			Double educationExpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthExpending = healthExpending;
		this.educationExpending = educationExpending;
	}
	
	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthExpending() {
		return healthExpending;
	}

	public void setHealthExpending(Double healthExpending) {
		this.healthExpending = healthExpending;
	}

	public Double getEducationExpending() {
		return educationExpending;
	}

	public void setEducationExpending(Double educationExpending) {
		this.educationExpending = educationExpending;
	}

	public Double salaryTax() {
		double monthSalary = salaryIncome / 12;
		if (monthSalary < 3_000) {
			return 0.0;			
		}
		else if (monthSalary >= 3_000 && monthSalary < 5_000) {
			return salaryIncome * 0.10;
		}
		else {
			return salaryIncome * 0.20;
		}
	}
	
	public Double serviceTax() {
		return servicesIncome * 0.15;
	}
	
	public Double capitalTax() {
		return capitalIncome * 0.20;
	}
	
	public Double grossTax() {
		return salaryTax() + serviceTax() + capitalTax();
	}
	
	public Double taxRebate() {
		double rebatableExpedings = healthExpending + educationExpending;
		double maxRebate = grossTax() * 0.30;
		
		if (rebatableExpedint <= maxRebate) {
			return rebatableExpedings;
		}
		else {
			return maxRebate;
		}
	}
	
	public Double netTax() {
		return grossTax() - taxRebate();
	}

}
