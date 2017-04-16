package hu.david.veres.graph.validator;

import hu.david.veres.graph.form.ProblemForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProblemFormValidator implements Validator {

    private static final String ALGORITHM_BACKTRACK_PATHLENGTHLIMITATION = "BackTrackPathLengthLimitation";
    private static final String ALGORITHM_BACKTRACK_OPTIMAL = "BackTrackOptimal";

    private static final String FIELD_STATESPACE = "stateSpace";
    private static final String FIELD_ALGORITHMS = "algorithms";
    private static final String FIELD_BACKTRACK_PATHLENGTHLIMITATION_LIMIT = "backTrackPathLengthLimitationLimit";
    private static final String FIELD_BACKTRACK_OPTIMAL_LIMIT = "backTrackOptimalLimit";

    private static final String ERROR_MESSAGE_EMPTY_STATE_SPACE = "State-space can't be empty!";
    private static final String ERROR_MESSAGE_NO_ALGORITHM = "You must choose at least one algorithm!";
    private static final String ERROR_MESSAGE_NO_LIMIT_BACKTRACK_PATHLENGTHLIMITATION = "You must declare the limit for the Backtrack with pathlength limitation algorithm!";
    private static final String ERROR_MESSAGE_INVALID_LIMIT_BACKTRACK_PATHLENGTHLIMITATION = "Backtrack with pathlength limitation algorithm's limit must be greater than 0!";
    private static final String ERROR_MESSAGE_NO_LIMIT_BACKTRACK_OPTIMAL = "You must declare the limit for the Backtrack branch and bound algorithm!";
    private static final String ERROR_MESSAGE_INVALID_LIMIT_BACKTRACK_OPTIMAL = "Backtrack branch and bound algorithm's limit must be greater than 0!";

    @Override
    public boolean supports(Class<?> clazz) {
        return ProblemForm.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ProblemForm problemForm = (ProblemForm) o;

        // validate state-space textarea
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_STATESPACE, ERROR_MESSAGE_EMPTY_STATE_SPACE);

        // validate search algorithms
        ValidationUtils.rejectIfEmpty(errors, FIELD_ALGORITHMS, ERROR_MESSAGE_NO_ALGORITHM);

        // validate limits
        if (problemForm.getAlgorithms().contains(ALGORITHM_BACKTRACK_PATHLENGTHLIMITATION)) {

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_BACKTRACK_PATHLENGTHLIMITATION_LIMIT, ERROR_MESSAGE_NO_LIMIT_BACKTRACK_PATHLENGTHLIMITATION);

            // validate limit value
            if (problemForm.getBackTrackPathLengthLimitationLimit() != null && problemForm.getBackTrackPathLengthLimitationLimit() <= 0) {
                errors.rejectValue(FIELD_BACKTRACK_PATHLENGTHLIMITATION_LIMIT, ERROR_MESSAGE_INVALID_LIMIT_BACKTRACK_PATHLENGTHLIMITATION);
            }

        }

        if (problemForm.getAlgorithms().contains(ALGORITHM_BACKTRACK_OPTIMAL)) {

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_BACKTRACK_OPTIMAL_LIMIT, ERROR_MESSAGE_NO_LIMIT_BACKTRACK_OPTIMAL);

            // validate limit value
            if (problemForm.getBackTrackOptimalLimit() != null && problemForm.getBackTrackOptimalLimit() <= 0) {
                errors.rejectValue(FIELD_BACKTRACK_OPTIMAL_LIMIT, ERROR_MESSAGE_INVALID_LIMIT_BACKTRACK_OPTIMAL);
            }

        }

    }

}
