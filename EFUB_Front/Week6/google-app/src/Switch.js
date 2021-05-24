import React from 'react';

import "./Switch.css"

const Switch = ({ rounded = false, isToggled, onToggle }) => {

    return (
        <label className="switch">
            <input type="checkbox" checked={isToggled} onchange={onToggle} />

            <span className="slider rounded" />
        </label>
    );
};

export default Switch;