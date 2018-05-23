package model;

/**
 * The receipt of a sale.
 */
public class Receipt {
    private final Sale sale;

    /**
     * Creating an instance.
     * @param sale The current sale to print a receipt for.
     */
    Receipt(Sale sale) {
        this.sale = sale;
    }

    /**
     * Creates a receipt with sale information.
     * @return The Receipt
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "----------------- Receipt -----------------");
        builder.append("\n");
        builder.append("Time of sale: ");
        appendLine(builder, sale.getTimeStamp().toString());
        builder.append("\n");
        builder.append("Items Bought: " + "\n");
        appendLine(builder, sale.getItemInfo());
        builder.append("Total Cost: ");
        appendLine(builder, Double.toString(sale.getTotalWithTaxes()));
        builder.append("Change: ");
        appendLine(builder, Double.toString(sale.getChangeAmount()));
        builder.append("\n");
        builder.append("----------------- Receipt ends --------------\n");
        return builder.toString();
    }

    /**
     * Adds a string of text and moves down one line.
     * @param builder The receipt builder.
     * @param line The string of text to add.
     */
    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }
}

