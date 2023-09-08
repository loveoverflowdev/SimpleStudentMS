package domain.entities;

public class SubjectGrade {
    private Subject subject;
    private double midTermTestScore;
    private double finalTermTestScore;

    public SubjectGrade(Subject subject, double midTermTestScore, double finalTermTestScore) {
        this.subject = subject;
        this.midTermTestScore = midTermTestScore;
        this.finalTermTestScore = finalTermTestScore;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getMidTermTestScore() {
        return midTermTestScore;
    }

    public double getFinalTermTestScore() {
        return finalTermTestScore;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setMidTermTestScore(double midTermTestScore) {
        this.midTermTestScore = midTermTestScore;
    }

    public void setFinalTermTestScore(double finalTermTestScore) {
        this.finalTermTestScore = finalTermTestScore;
    }
}
