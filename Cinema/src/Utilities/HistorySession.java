package Utilities;

import entities.session.Session;
import repositories.Transaction;

import java.util.List;

import static repositories.ClientProgram.transactionList;
import static repositories.SessionManager.sessionList;

public class HistorySession
{
//    public static List<Double> total;
    public static void history (List<Transaction> transactionList)
    {
        for (Transaction transaction : transactionList)
        {
            for (Session session : sessionList)
            {
                if (transaction.getSession().equals(session))
                {
                    System.out.println("\n* SESSÃO -------------------------");
                    System.out.println("ID da sessão: " + transaction.getSession().getId());
                    System.out.println("Total em ingressos vendidos: " + transaction.getSession().getTotalPay());
                }
            }

        }
    }
}
