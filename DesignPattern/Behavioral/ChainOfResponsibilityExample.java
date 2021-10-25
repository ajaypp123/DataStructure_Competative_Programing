

// It can be modified further

interface Round {
    public boolean interview(int score);
    public void setNext(Round r);
}

class ProgrammingRound implements Round {
    Round _next;

    @Override
    public boolean interview(int score) {
        if(score != 0) {
            // First round so score must be zero
            return false;
        }

        int new_score = 90;
        if(new_score < 80) {
            return false;
        }

        return _next.interview(new_score);
    }

    @Override
    public void setNext(Round r) {
        _next = r;
    }
}

class HRRound implements Round {
    Round _next = null;

    @Override
    public boolean interview(int score) {
        int new_score = 90;
        if(new_score < 80) {
            return false;
        }
        // last round so return true
        if(_next!=null)
            return _next.interview(new_score);
        return true;
    }

    @Override
    public void setNext(Round r) {
        _next = r;
    }
}

class TechnicalRound implements Round {
    Round _next;

    @Override
    public boolean interview(int score) {
        int new_score = 90;
        if(new_score < 80) {
            return false;
        }

        return _next.interview(new_score);
    }

    @Override
    public void setNext(Round r) {
        _next = r;
    }
}

class ManagerRound implements Round {
    Round _next;

    @Override
    public boolean interview(int score) {
        int new_score = 90;
        if(new_score < 80) {
            return false;
        }

        return _next.interview(new_score);
    }

    @Override
    public void setNext(Round r) {
        _next = r;
    }
}

public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Round pr = new ProgrammingRound();
        Round hr = new HRRound();
        Round tr = new TechnicalRound();
        Round mr = new ManagerRound();

        pr.setNext(tr);
        tr.setNext(mr);
        mr.setNext(hr);

        System.out.println(pr.interview(0));
    }
}
