import java.nio.BufferUnderflowException;
import java.util.StringTokenizer;

public class LinkStack <E> {

    private LinkNode<E> mTop;

    public LinkStack()
    {
        mTop = null;
    }

    public boolean isEmpty()
    {
        return (mTop == null);
    }

    public void push(E element)
    {
        LinkNode<E> new_node = new LinkNode(element);
        new_node.next = mTop;
        mTop = new_node;
    }

    public E pop()
    {
        if (isEmpty())
        {
            throw new BufferUnderflowException();
        }

        E element = mTop.data;
        mTop = mTop.next;
        return element;
    }

    public E peek() /////////////////////////////////////////
    {
        if (isEmpty())
        {
            throw new BufferUnderflowException();
        }

        return mTop.data;
    }

    public String toString()
    {
        LinkNode<E> current_node = mTop;
        StringBuffer buffer = new StringBuffer();

        while (current_node != null)
        {
            buffer.append(current_node.data);
            buffer.append(" ");
            current_node = current_node.next;
        }

        return buffer.toString();
    }


}
