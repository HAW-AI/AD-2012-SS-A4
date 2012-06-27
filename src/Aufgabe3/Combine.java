/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maiwald
 */
public class Combine
{

    private final String with;
    private final String prepend;
    private final String append;
    private final boolean notNulls;
    private final boolean trim;
    private final boolean notEmpty;

    private Combine(String with, String prepend, String append, boolean notNulls, boolean trim, boolean notEmpty)
    {
        this.with = with;
        this.prepend = prepend;
        this.append = append;

        this.notNulls = notNulls;
        this.trim = trim;
        this.notEmpty = notEmpty;
    }

    public static Combine with(String withValue)
    {
        return new Combine(withValue, null, null, false, false, false);
    }

    public Combine prepend(String prependValue)
    {
        return new Combine(this.with, prependValue, this.append, this.notNulls, this.trim, this.notEmpty);
    }

    public Combine append(String appendValue)
    {
        return new Combine(this.with, this.prepend, appendValue, this.notNulls, this.trim, this.notEmpty);
    }

    public Combine notNulls()
    {
        return new Combine(this.with, this.prepend, this.append, true, this.trim, this.notEmpty);
    }

    public Combine trim()
    {
        return new Combine(this.with, this.prepend, this.append, this.notNulls, true, this.notEmpty);
    }

    public Combine notEmpty()
    {
        return new Combine(this.with, this.prepend, this.append, this.notNulls, this.trim, true);
    }

    public String from(double[] ary)
    {
        List<String> stringList = new ArrayList<>();
        for (double d : ary)
        {
            stringList.add(Double.toString(d));
        }

        return this.buildString(stringList);
    }

    public String from(int[] ary)
    {
        List<String> stringList = new ArrayList<>();
        for (int i : ary)
        {
            stringList.add(Integer.toString(i));
        }

        return this.buildString(stringList);
    }

    public String from(List<? extends Object> list)
    {
        List<String> stringList = new ArrayList<>();

        if (list != null)
        {
            for (Object o : list)
            {
                stringList.add((o != null) ? o.toString() : null);
            }
        }

        return this.buildString(this.filter(stringList));
    }

    private List<String> filter(List<String> list)
    {
        if (this.notNulls)
        {
            list = filterNulls(list);
        }

        if (this.trim)
        {
            list = filterTrim(list);
        }
        
        if (this.notEmpty)
        {
            list = filterEmpty(list);
        }

        return list;
    }

    private List<String> filterEmpty(List<String> list)
    {
        List<String> result = new ArrayList<>();
        for (String s : list)
        {
            if (s == null || !s.trim().equals(""))
            {
                result.add(s);
            }
        }

        return result;
    }

    private List<String> filterTrim(List<String> list)
    {
        List<String> result = new ArrayList<>();
        for (String s : list)
        {
            result.add((s == null) ? null : s.trim());
        }

        return result;
    }

    private List<String> filterNulls(List<String> list)
    {
        List<String> result = new ArrayList<>();
        for (String s : list)
        {
            if (s != null)
            {
                result.add(s);
            }
        }

        return result;
    }

    private String buildString(List<String> list)
    {
        return String.format("%s%s%s", this.getPrepend(), this.join(list, this.getWith()), this.getAppend());
    }

    private String getWith()
    {
        if (this.with == null)
        {
            return "";
        } else
        {
            return this.with;
        }
    }

    private String getPrepend()
    {
        if (this.prepend == null)
        {
            return "";
        } else
        {
            return this.prepend;
        }
    }

    private String getAppend()
    {
        if (this.append == null)
        {
            return "";
        } else
        {
            return this.append;
        }
    }

    private String join(List<String> ary, String separator)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ary.size(); i++)
        {
            builder.append(ary.get(i));
            if (i != ary.size() - 1)
            {
                builder.append(separator);
            }
        }

        return builder.toString();
    }
}
