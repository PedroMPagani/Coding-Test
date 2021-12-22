package me.paganidev.psolving.p2;

import java.util.Comparator;
import java.util.List;

public class AlgorithmP2 {

    public List<List<Character>> array(List<String> list){
        return list.stream().filter(s->s != null && !s.contains("&") && !s.contains("!")).map(q->q.chars().filter(q1->q1 % 10 != 0))
                .map(s->s.mapToObj(f->(char)f).sorted(Comparator.comparingInt(x -> (char)x).reversed()).toList()).toList();
    }

}
