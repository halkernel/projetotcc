package model;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

public class DynamicDualListModel<T> extends DualListModel<T> {

/**
 * 
 */
    private static final long serialVersionUID = 1L;

    private List<T> sourceBuffer;

    private boolean view = false;
    
    public DynamicDualListModel(){
    	super();
    }

    public DynamicDualListModel(List<T> source, ArrayList<T> target) {
            super(source, target);
            this.setSource(source);
    }

    @Override
    public void setTarget(List<T> target) {
            super.setTarget(target);
            updateSourceView();
    }

    @Override
    public void setSource(List<T> source) {
            if (!view) {
                    sourceBuffer = source;
                    updateSourceView();
            } else {
                    super.setSource(source);
            }
    }

    private void updateSourceView() {
            List<T> sourceView = new ArrayList<T>();
            for (T obj : sourceBuffer) {
                    if (getTarget() != null && !getTarget().contains(obj))
                            sourceView.add(obj);
            }
            view = true;
            this.setSource(sourceView);
    }
}