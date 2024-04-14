package org.example.logic;

import org.example.model.Polynomial;

public class ResultDivision {

    private Polynomial quotient;
    private Polynomial reminder;

    public ResultDivision(Polynomial quotient, Polynomial reminder) {
        this.quotient = quotient;
        this.reminder = reminder;
    }

    public Polynomial getQuotient() {
        return quotient;
    }

    public Polynomial getReminder() {
        return reminder;
    }
}
