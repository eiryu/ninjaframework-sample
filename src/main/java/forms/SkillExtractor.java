package forms;

import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import ninja.Context;
import ninja.params.ArgumentExtractor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/15
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class SkillExtractor implements ArgumentExtractor<String[]> {

    @Override
    public String[] extract(Context context) {
        List<String> skills = context.getParameterValues("skill");
        if (skills != null) {
            return Iterables.toArray(skills, String.class);
        }
        return null;
    }

    @Override
    public Class<String[]> getExtractedType() {
        return String[].class;
    }

    @Override
    public String getFieldName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
