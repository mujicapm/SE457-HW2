package org.mmujicap;

import java.util.ArrayList;
import java.util.List;
import org.mmujicap.QuoteObject;

public class QuoteList<Q> extends ArrayList<org.mmujicap.QuoteObject> {

    private static QuoteList single_instance = null;

    private QuoteList() {
        createQuoteList();
    }

    public static QuoteList getInstance()
    {
        if (single_instance == null)
            single_instance = new QuoteList();

        return single_instance;
    }

    public void createQuoteList()
    {
        org.mmujicap.QuoteObject quote1 = new org.mmujicap.QuoteObject(1,"The best preparation for tomorrow is doing your best today. -H. Jackson Brown, Jr");
        org.mmujicap.QuoteObject quote2 = new org.mmujicap.QuoteObject(2,"Believe you can and you're halfway there. -Theodore Roosevelt");
        org.mmujicap.QuoteObject quote3 = new org.mmujicap.QuoteObject(3,"There is nothing impossible to him who will try. -Alexander the Great");
        org.mmujicap.QuoteObject quote4 = new org.mmujicap.QuoteObject(4,"The object of life is not to be on the side of the majority, but to escape finding oneself in the ranks of the insane. -Marcus Aurelius");
        org.mmujicap.QuoteObject quote5 = new org.mmujicap.QuoteObject(5,"What lies behind you and what lies in front of you, pales in comparison to what lies inside of you. -Ralph Waldo Emerson");

        this.add(quote1);
        this.add(quote2);
        this.add(quote3);
        this.add(quote4);
        this.add(quote5);
    }

    public List<QuoteObject> getListOfQuotes() {
        return this;
    }
}
