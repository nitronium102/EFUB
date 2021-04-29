import React, { Component } from "react";

class Clock extends Component {
    constructor(props) {
        super(props);
        this.state = { date: new Date() }; // date라는 state를 지정
    }
    render() {
        return (
            <div>
                <h2>It is {this.state.date.toLocaleTimeString()}.</h2>
            </div>
        );
    }
}

export default Clock;