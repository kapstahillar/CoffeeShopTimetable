package com.kapstahillar.coffeeshop.component;

import com.kapstahillar.coffeeshop.model.Timeslot;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;

// TimeslotButton is a simple button that also contains
// timeslot info.
public class TimeSlotButton extends Button {

    // Current free capacity of this slot
    private int currentSlotsRemaining;

    // Timeslot model associated with this button
    private Timeslot timeSlot;

    // Maximum slot capacity for a timeslot
    private int maxSlotCapacity;

    public TimeSlotButton(Timeslot timeSlot, int currentSlotCapacity, int maxSlotCapacity) {
        this.timeSlot = timeSlot;
        this.currentSlotsRemaining = currentSlotCapacity;
        this.maxSlotCapacity = maxSlotCapacity;
        initialiseButton();
    }

    public void updateTimeSlot(Timeslot newTimeSlot, boolean hasSuccessState) {
        this.timeSlot = newTimeSlot;
        this.currentSlotsRemaining = maxSlotCapacity - newTimeSlot.getBookedCustomers().size();
        updateState(hasSuccessState);
    }

    private void initialiseButton() {
        setClassName("timeslot-button");
        updateState();
    }

    // Concatenates timeslot name and current slot capacity
    public void updateNameText(int currentCapacity) {
        setText(getButtonNameString(currentCapacity));
    }

    // Sets amount of slots remaining and call updates on state of this button
    public void setCurrentSlotsRemaining(int slotsRemaining) {
        this.currentSlotsRemaining = slotsRemaining;
        updateState();
    }

    // Update state of this button.
    private void updateState(boolean hasSuccessState) {
        updateNameText(currentSlotsRemaining);
        if (currentSlotsRemaining == 0) {
            addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        }
        if (hasSuccessState) {
            removeThemeVariants(ButtonVariant.LUMO_CONTRAST);
            addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        }
    }

    private void updateState() {
        updateState(false);
    }

    public Timeslot getTimeSlot() {
        return timeSlot;
    }

    private String getButtonNameString(int currentCapacity) {
        return timeSlot.getName() + " (" + String.valueOf(currentCapacity) + ")";
    }


}
