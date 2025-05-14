import java.util.*;
import java.util.function.BiFunction;

public class Automaton {
    private final Map<State, BiFunction<Character, State, State>>
            transitionTable = new HashMap<>();

    public Automaton() {
        transitionTable.put(State.START, (ch, s) -> ch == '<'
                ? State.AFTER_LESS : State.ERROR);

        transitionTable.put(State.AFTER_LESS, (ch, s) -> {
            if (ch == '+' || ch == '-') return State.AFTER_SIGN;
            if (isLetterPtoZ(ch)) return State.IN_LETTERS;
            return State.ERROR;
        });

        transitionTable.put(State.AFTER_SIGN, (ch, s) -> isDigit05(ch) ? State.IN_DIGITS : State.ERROR);

        transitionTable.put(State.IN_DIGITS, (ch, s) -> {
            if (isDigit05(ch)) return State.IN_DIGITS;
            if (ch == '>') return State.ACCEPT;
            return State.ERROR;
        });

        transitionTable.put(State.IN_LETTERS, (ch, s) -> {
            if (isLetterPtoZ(ch)) return State.IN_LETTERS;
            if (ch == '>') return State.ACCEPT;
            return State.ERROR;
        });
    }

    public boolean checkWord(String word) {
        State state = State.START;

        for (char ch : word.toCharArray()) {
            BiFunction<Character, State, State> transition = transitionTable
                    .get(state);
            if (transition == null) return false;

            state = transition.apply(ch, state);
            if (state == State.ERROR) return false;
        }

        return state == State.ACCEPT;
    }

    private boolean isDigit05(char ch) {
        return ch >= '0' && ch <= '5';
    }

    private boolean isLetterPtoZ(char ch) {
        return ch >= 'P' && ch <= 'Z';
    }
}
