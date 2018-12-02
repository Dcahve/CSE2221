import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Put your name here
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        NaturalNumber input = model.bottom();
        NaturalNumber output = model.top();

        view.updateBottomDisplay(input);
        view.updateTopDisplay(output);
        //divide condition
        if (model.bottom().compareTo(new NaturalNumber2()) > 0) {
            boolean allowed = true;
            view.updateDivideAllowed(allowed);
        } else {
            boolean allowed = false;
            view.updateDivideAllowed(allowed);
        }
        // subtract
        if (model.bottom().compareTo(model.top()) < 0) {
            boolean allowed = true;
            view.updateSubtractAllowed(allowed);
        } else {
            boolean allowed = false;
            view.updateSubtractAllowed(allowed);
        }
        // power
        if (model.bottom().compareTo(INT_LIMIT) <= 0) {
            view.updatePowerAllowed(true);
        } else {
            view.updatePowerAllowed(false);
        }
        // root
        if (model.bottom().compareTo(TWO) >= 0
                && model.bottom().compareTo(INT_LIMIT) <= 0) {
            view.updateRootAllowed(true);
        } else {
            view.updateRootAllowed(false);
        }

    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber buttom = this.model.bottom();

        top.copyFrom(buttom);

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber buttom = this.model.bottom();

        buttom.add(top);
        top.clear();

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber buttom = this.model.bottom();

        top.subtract(buttom);
        buttom.transferFrom(top);

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processMultiplyEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber buttom = this.model.bottom();

        buttom.multiply(top);
        top.clear();

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber buttom = this.model.bottom();

        NaturalNumber r = top.divide(buttom);
        buttom.transferFrom(top);
        top.transferFrom(r);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processPowerEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber buttom = this.model.bottom();

        top.power(buttom.toInt());
        buttom.transferFrom(top);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRootEvent() {

        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        top.root(bottom.toInt());
        bottom.transferFrom(top);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.multiplyBy10(digit);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

}
