import React, { useEffect, useCallback } from "react";
import { NewEmployeeForm } from "./NewEmployeeForm.jsx";
import { connect } from "react-redux";
import { createEmployee } from "../../../../redux/ducks/employees";
import { loadEducations } from "../../../../redux/ducks/educations";


const NewEmployeeFormContainer = ({ createEmployee, isCreating, loadEducations, educations }) => {

    const loadEducationList = useCallback(() => {
        loadEducations();
    }, []);

    useEffect(() => loadEducationList(), [loadEducationList]);

    return <NewEmployeeForm 
                educations={educations} 
                onSubmit={(data) => createEmployee(data)} />

};

const mapStateToProps = (state) => ({
    isCreating: state.employee.isFetching,
    educations: state.educations.educations
});

const mapDispatchToProps = {
    createEmployee,
    loadEducations
};


const ReduxNewEmployeeFormContainer = connect(mapStateToProps, mapDispatchToProps)
    (NewEmployeeFormContainer);

export { ReduxNewEmployeeFormContainer as NewEmployeeFormContainer };