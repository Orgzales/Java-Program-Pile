public class LinkNode <T>
{
    public T data;
    public LinkNode<T> next;

    public LinkNode(T stuff)
    {
        data = stuff;
        next = null;
    }
}