package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNuber;
	private Date checkin;
	private Date checkout;

	public Reservation() {
	}

	public Reservation(Integer roomNuber, Date checkin, Date checkout) {
		this.roomNuber = roomNuber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNuber() {
		return roomNuber;
	}

	public void setRoomNuber(Integer roomNuber) {
		this.roomNuber = roomNuber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			return "as datas de reserva para atualiza��o devem ser datas futuras";
		}
		if (!checkout.after(checkin)) {
			return "A data de check-out deve ser posterior � data de check-in";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("quarto, " + roomNuber);
		sb.append(", check-in: " + sdf.format(checkin));
		sb.append(", check-out: " + sdf.format(checkout));
		sb.append(", " + duration() + " noites.");

		return sb.toString();
	}
}
