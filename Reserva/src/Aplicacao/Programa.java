package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reserva;
import exessoes.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {//tratar excessões
			System.out.print("Informe o numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do Check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do Check-out  (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Informe a nova data da reserva:");
			System.out.print("Nova data do Check-in  (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Nova data do Check-out  (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {//trata no caso de erro da data invalidada
			System.out.println("Data invalida");
		}// criar o pocate de excessao propria com a mensagem que quero
		catch (DomainException e) {//a mensagem vinvula a excessao tratada
			System.out.println("Erro na reserva: " + e.getMessage());
		}   // 
		catch (RuntimeException e) {// tratando  com excessao generica para qq erro inesperado tem estrutura de herança
			System.out.println("Erro na informação");
		}

		sc.close();
	}
}