package view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import model.YbocsModel;
import presenter.YbocsPresenter;
import view.common.MainLayout;

/**
 * ybocstest view implementation. Here are the Vaadin components defined
 */
@Route(value = "ybocstest", layout = MainLayout.class)
public class YbocsTestImpl extends VerticalLayout implements IYbocsTestView {
	/**
	 * @listeners: Arraylist with all listeners for the Moodtests 
	 * @moodButtonGroups: saves the input for a specific radio button
	 * @display: shows the calculated Mood of the User
	 */
	private List<IYbocsTestViewListener> listeners = new ArrayList<IYbocsTestViewListener>();
	private List<RadioButtonGroup<Integer>> ybocsButtonGroups = new ArrayList<RadioButtonGroup<Integer>>();

	private TextField displayField = new TextField();

	public YbocsTestImpl() {
		YbocsModel ybocsModel = new YbocsModel();
		new YbocsPresenter(ybocsModel, this);

		Text titleText = new Text("Yale Brown OCD Scale");
		Text descriptionText = new Text("Please answer the following questions.");
		add(titleText, descriptionText);
		
		/**
		 * calling add method from Vaadin to call the another Method for creating a Radio Button Group 
		 * with a specific label
		 * 
		 * a new legend was created for each radio group. this could not be auto-generated because the
		 * numerical values always change (somethimes 0 is none, other times 0 is Always)
		 * 
		 */
		add(createRadioButtonGroup("How much time do you spend on obsessive thoughts?"));
		Text legend1 = new Text("0 = None, 1 = 0-1 hrs/day, 2 = 1-3 hrs/day, 3 = 3-8 hrs/day, 4 = More than 8 hrs/day");
		add(legend1);

		add(createRadioButtonGroup(
				"How much do your obsessive thoughts interfere with your personal, social, or work life?"));
		Text legend2 = new Text(
				"0 = None, 1 = Mild, 2 = Definite but manageable, 3 = Substantial interference, 4 = Severe");
		add(legend2);

		add(createRadioButtonGroup("How much do your obsessive thoughts distress you?"));
		Text legend3 = new Text(
				"0 = None, 1 = Little, 2 = Moderate but manageable, 3 = Severe, 4 = Nearly constant, Disabling");
		add(legend3);

		add(createRadioButtonGroup("How hard do you try to resist your obsessions?"));
		Text legend4 = new Text(
				"0 = Always, 1 = Try much of the time, 2 = Try some of the time, 3 = Rarely try. Often yield, 4 = Never try. Completely yield");
		add(legend4);

		add(createRadioButtonGroup("How much control do you have over your obsessive thoughts?"));
		Text legend5 = new Text(
				"0 = Complete control, 1 = Much control, 2 = Some control, 3 = Little control, 4 = No control");
		add(legend5);

		add(createRadioButtonGroup("How much time do you spend performing compulsive behaviors?"));
		Text legend6 = new Text("0 = None, 1 = 0-1 hrs/day, 2 = 1-3 hrs/day, 3 = 3-8 hrs/day, 4 = More than 8 hrs/day");
		add(legend6);

		add(createRadioButtonGroup(
				"How much do your compulsive behaviors interfere with your personal, social, or work  life?"));
		Text legend7 = new Text(
				"0 = None, 1 = Mild, 2 = Definite but manageable, 3 = Substantial interference, 4 = Severe");
		add(legend7);

		add(createRadioButtonGroup(
				"How anxious would you feel if you were prevented from performing your compulsive behaviors?"));
		Text legend8 = new Text(
				"0 = None, 1 = Little, 2 = Moderate but manageable, 3 = Severe, 4 = Nearly constant, Disabling");
		add(legend8);

		add(createRadioButtonGroup("How hard do you try to resist your compulsive behaviors?"));
		Text legend9 = new Text(
				"0 = Always, 1 = Try much of the time, 2 = Try some of the time, 3 = Rarely try. Often yield, 4 = Never try. Completely yield");
		add(legend9);

		add(createRadioButtonGroup("How much control do you have over your compulsive behaviors?"));
		Text legend10 = new Text(
				"0 = Complete control, 1 = Much control, 2 = Some control, 3 = Little control, 4 = No control");
		add(legend10);

		displayField.setReadOnly(true);
		add(displayField);
		add(createButton("Calculate score"));
	}
	
	/**
	 * Method created so that every time its called it will create a radiobutton group with a specific label
	 * @setItems: creates the scale for the ybocs scale  
	 * 
	 */
	private RadioButtonGroup<Integer> createRadioButtonGroup(String label) {
		RadioButtonGroup<Integer> someRadioButtonGroup = new RadioButtonGroup<Integer>();
		ybocsButtonGroups.add(someRadioButtonGroup);
		someRadioButtonGroup.setLabel(label);
		someRadioButtonGroup.setItems(0, 1, 2, 3, 4);
		return someRadioButtonGroup;
	}

	private Button createButton(String label) {
		return new Button(label, event -> {
			for (IYbocsTestViewListener listener : listeners) {
				listener.buttonClick(ybocsButtonGroups);
			}
		});
	}

	public void setDisplay(String displayString) {
		displayField.setValue(displayString);
	}

	public void showNotification(String notification) {
		Notification.show(notification);
	}

	public void addYbocsListener(IYbocsTestViewListener listener) {
		listeners.add(listener);
	}
}