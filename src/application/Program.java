package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Número do quarto: ");
			int roomNuber = sc.nextInt();
			System.out.print("Data de Check-in (dd/MM/AAAA): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data de Check-out (dd/MM/AAAA): ");
			Date checkout = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNuber, checkin, checkout);
			System.out.println("Dados da reserva: " + reservation);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.print("Data de Check-in (dd/MM/AAAA): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data de Check-out (dd/MM/AAAA): ");
			checkout = sdf.parse(sc.next());

			reservation.updateDates(checkin, checkout);
			System.out.println("Dados atualizados: " + reservation);

			sc.close();
		} 
		catch (ParseException e) {
			System.out.println("Data inválida!");
		}
		catch (DomainException e) {
			System.out.println("Erro em reserva: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Por favor digite valores válidos!");
		}
		catch (RuntimeException e) {
			System.out.println("Ops, ocorreu um erro inesperado!");
		}
		
	}

}
