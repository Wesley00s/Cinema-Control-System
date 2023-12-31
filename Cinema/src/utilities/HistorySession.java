package utilities;

import entities.session.Session;

import static repositories.SessionManager.finishSessionList;

public class HistorySession
{
    public static void history ()
    {
        if (finishSessionList.isEmpty())
        {
            System.out.println("\nNenhuma sessão foi finalizada ainda!\n");
            return;
        }
        int contSession = 1;
        for (Session session : finishSessionList)
        {
            System.out.println("\n* SESSÃO " + contSession + " FINALIZADA -------------------------");
            System.out.println("ID da sessão: " + session.getId());
            System.out.println("Data da sessão: " + session.getSessionDate());
            System.out.println("Total em ingressos vendidos: R$ " + session.getTotalPay());
            contSession++;
        }
    }
}