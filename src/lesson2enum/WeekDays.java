package lesson2enum;

public enum WeekDays {
     MONDAY {
        @Override
        String nextDays() {
            return null;
        };
    }, TUESDAY {
        @Override
        String nextDays() {
            return null;
        }
    }, WEDNESDAY {
        @Override
        String nextDays() {
            return null;
        }
    }, THURSDAY {
        @Override
        String nextDays() {
            return null;
        }
    }, FRIDAY {
        @Override
        String nextDays() {
            return null;
        }
    }, SATURDAY {
        @Override
        String nextDays() {
            return null;
        }
    }, SUNDAY {
        @Override
        String nextDays() {
            return null;
        }
    };


    abstract String nextDays();
    }

