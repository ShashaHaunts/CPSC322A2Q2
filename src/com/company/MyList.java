package com.company;

import java.util.ArrayList;

public abstract class MyList<N> {

        public abstract Node pop();
        public abstract void add(Node n);
        public abstract int size();
        public abstract boolean isEmpty();

}
