package presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import com.vaadin.flow.component.textfield.TextArea;

import model.common.Diary;
import view.IDiaryView;

public class DiaryPresenter implements IDiaryView.IDiaryViewListener {
	private Diary model;
	private IDiaryView view;

	public DiaryPresenter(Diary model, IDiaryView view) {
		this.model = model;
		this.view = view;
		view.setUserInput("");
		view.addDiaryListener(this);
	}

	@Override
	public void buttonClick(String diariestext) {
		model.setDailyEntry(diariestext);
		view.showNotification("New entry added.");
		//view.purgeTextArea(view.getTextArea());
		//String textPattern = String.format("Diary input from %s",
		 //LocalDate.now().toString());
		view.setUserInput(model.getDailyEntry());
	}
}
