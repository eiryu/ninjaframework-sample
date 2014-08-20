package forms;

import com.google.common.base.Strings;
import ninja.Context;
import ninja.params.ArgumentExtractor;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/15
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public class SexExtractor implements ArgumentExtractor<Sex> {

    @Override
    public Sex extract(Context context) {
        String sex = context.getParameter("sexenum");
        if (!Strings.isNullOrEmpty(sex)) {
            return Enum.valueOf(Sex.class, sex);
        }
        return null;
    }

    @Override
    public Class<Sex> getExtractedType() {
        return Sex.class;
    }

    @Override
    public String getFieldName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
