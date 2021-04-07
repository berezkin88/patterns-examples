abstract class Link {
    protected Link next;

    abstract boolean handle(String value);

    public Link add(Link nextLink) {
        this.next = nextLink;
        return this;
    }
}
