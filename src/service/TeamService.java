package service;

import java.util.Scanner;

import entity.Team;

import repository.TeamRepository;

public class TeamService {
	public void printTeamDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to IPL portal");
		System.out.println("Please select following options");
		System.out.println("1. Get All Team Details");
		System.out.println("2. Get team details separately");

		int input = sc.nextInt();
		sc.nextLine();
		int teamid = 0;

		Team[] team = TeamRepository.getAllTeam();
		
		if (input == 1) {
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i]);
			}
		} else if (input == 2) {
			System.out.println("Find team using id or short name!");
			String findTeam = sc.nextLine();

			if (findTeam.matches("\\d+")) {
				teamid = Integer.parseInt(findTeam);
			}
			for (int i = 0; i < team.length; i++) {
				Team t = team[i];
				if (findTeam.equalsIgnoreCase(t.getShortName()) || teamid == t.getId()) {
					System.out.println(t);
					break;
				}else {
					System.out.println("Invalid Input");
				}
			}
		} else {
			System.out.println("Invalid Input!");
		}
		sc.close();
	}
}
