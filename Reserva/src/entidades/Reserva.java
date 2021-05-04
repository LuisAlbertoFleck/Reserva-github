package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exessoes.DomainException;

public class Reserva {

	private Integer QuartoNumero;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer QuartoNumero, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior à data de check-in");// tratando com IllegalArgumentException quando o argumento esta errado, quando altera as datas
		}// propagando a excessao
		this.QuartoNumero = QuartoNumero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getQuartoNumero() {
		return QuartoNumero;
	}

	public void setQuartoNumero(Integer QuartoNumero) {
		this.QuartoNumero = QuartoNumero;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	// uso o meu metodo para trocar as execoes
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas de reserva para atualização devem ser datas futuras");
		} //uso o trow new com a classe excessoes PRECISA COLOCAR NO INICIO DO METODO
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior à data de check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+ QuartoNumero
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duracao()
			+ " noites";
	}
}