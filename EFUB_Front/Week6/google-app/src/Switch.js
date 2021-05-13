import React from 'react';
import "./Switch.css"

const Switch = (isChecked, handleToggle, onColor) => {
    return (
        <div className="switch">
            <input
                type="checkbox"
                className={`react-switch-checkbox`}
                checked={isChecked} // true면 체크, false면 체크 해제(checked)
                onChange={handleToggle} // state를 변경하는 함수(handleToggle)
                id={`react-switch-new`}
            />
            <label
                style={{ background: isChecked && onColor }}
                className="react-switch-label"
                htmlFor={`react-switch-new`}
            >
                <span className={`react-switch-button`} />
            </label>
        </div>
    );
};

export default Switch;