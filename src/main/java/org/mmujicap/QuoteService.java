package org.mmujicap;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


/**
 * Root resource (exposed at "v1/quoteservice" path)
 */
@Path("v1/quoteservice")
public class QuoteService {

    QuoteList<QuoteObject> listOfQuotes = QuoteList.getInstance();

    // Gets all quotes that have been added to the service,
    // ordered by identifier
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuoteObject> getAllQuotes()
    {
        return listOfQuotes;
    }

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a application/json response.
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public QuoteObject getQuoteById(@PathParam("id") int id)
    {
        for (QuoteObject quote : listOfQuotes) {
            if(quote.getId()==id)
                return quote;
        }

        return null;
    }

    // Adds a quote and returns the quote identifier
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public int addQuote(String quote){
        if (listOfQuotes.size() == 0) {
            QuoteObject newQuote = new QuoteObject(1, quote);
            return 1;
        } else {
            int newID = listOfQuotes.get(listOfQuotes.size()-1).id + 1;
            QuoteObject newQuote = new QuoteObject(newID, quote);
            listOfQuotes.add(newQuote);
            return newID;
        }
    }

    // Replace a quote with a given identifier with a new quote
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public QuoteObject updateQuote(@PathParam("id") int id, QuoteObject newQuote) {
        for (QuoteObject quote : listOfQuotes) {
            if (quote.getId() == id) {
                quote.setQuote(newQuote.getQuote());
                return quote;
            }
        }
        return null;
    }

    // Delete the quote with the given identifier.
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteQuote(@PathParam("id") int id) {
        listOfQuotes.removeIf(e -> e.getId()==id);
    }
}
