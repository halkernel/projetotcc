package model;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

public class DynamicDualListModel<Escola> extends DualListModel<Escola> {

/**
 * 
 */
    private static final long serialVersionUID = 1L;

    private List<Escola> sourceBuffer;

    private boolean view = false;
    
    public DynamicDualListModel(){
    	super();
    }

    public DynamicDualListModel(List<Escola> source, ArrayList<Escola> target) {
            super(source, target);
            this.setSource(source);
    }

    @Override
    public void setTarget(List<Escola> target) {
            super.setTarget(target);
            updateSourceView();
    }

    @Override
    public void setSource(List<Escola> source) {
            if (!view) {
                    sourceBuffer = source;
                    updateSourceView();
            } else {
                    super.setSource(source);
            }
    }
    
    private void updateSourceView() {
            List<Escola> sourceView = new ArrayList<Escola>();
            for (Escola obj : sourceBuffer) {
                    if (getTarget() != null && !getTarget().contains(obj))
                            sourceView.add(obj);
            }
            view = true;
            this.setSource(sourceView);
    }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public List<Escola> getSource() {
		// TODO Auto-generated method stub
		return super.getSource();
	}

	@Override
	public List<Escola> getTarget() {
		// TODO Auto-generated method stub
		return super.getTarget();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
    
    
}