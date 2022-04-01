package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
				
		System.out.print("Número do quarto: ");
		int roomNuber = sc.nextInt();
		System.out.print("Data de Check-in (dd/MM/AAAA): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data de Check-out (dd/MM/AAAA): ");
		Date checkout = sdf.parse(sc.next());
		
		if(!checkout.after(checkin)) {
			System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");
		}
		else {
			Reservation reservation = new Reservation(roomNuber, checkin, checkout);
			System.out.println("Dados da reserva: " + reservation);
			
			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Data de Check-in (dd/MM/AAAA): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de Check-out (dd/MM/AAAA): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Erro na reserva: as datas de reserva para atualização devem ser datas futuras");
			}
			else if(!checkout.after(checkin)) {
				System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");
			}
			else {
				reservation.updateDates(checkin, checkout);
				System.out.println("Dados atualizados: " + reservation);
			}
		}
		
		
		sc.close();
	}

}
