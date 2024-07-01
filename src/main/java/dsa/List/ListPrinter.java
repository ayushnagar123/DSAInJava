package dsa.List;
import java.util.List;

import dsa.utils.PrintInterface;

public class ListPrinter<T> implements PrintInterface {

    List<T> l;

    public ListPrinter(List<T> list)
    {
        this.l = list;
    }

    public void print()
    {
        for(T val: l)
        {
            System.out.print(val + " ");
        }
    }
}