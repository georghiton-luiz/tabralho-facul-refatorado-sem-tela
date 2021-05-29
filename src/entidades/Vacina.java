package entidades;

import java.time.LocalDate;

public class Vacina {

	private LocalDate dataVacina1;
	private LocalDate dataVacina2;
	private Integer resp;

	public Vacina() {

	}

	public LocalDate getDataVacina1() {
		return dataVacina1;
	}

	public void setDataVacina1(LocalDate dataVacina1) {
		this.dataVacina1 = dataVacina1;
	}

	public LocalDate getDataVacina2() {
		return dataVacina2;
	}

	public void setDataVacina2(LocalDate dataVacina2) {
		this.dataVacina2 = dataVacina2;
	}

	public Integer getResp() {
		return resp;
	}

	public void setResp(Integer resp) {
		this.resp = resp;
	}
	
	public String getTipoVacina() {
		switch (resp) {
			case 1 -> {
				return "CoronaVac";
			}
			case 2 -> {
				return "Oxford/Astrazeneca";
			}
			default -> System.out.println("Opção invalida");
		}

		return null;
	}
}
