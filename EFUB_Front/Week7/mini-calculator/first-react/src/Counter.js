import React, { Component } from "react";

class Counter extends Component {

    state = { number: 0 };

    plusNum = () => {
        this.setState({ number: this.state.number + 1 })
    }

    minusNum = () => {
        this.setState({ number: this.state.number - 1 })
    }

    render() {
        return (
            <div>
                <h1>Count</h1>
                <h2>값 : {this.state.number} </h2>
                <button onclick={this.plusNum}>Plus</button>
                <button onclick={this.minusNum}>Minus</button>
            </div>
        );
    }
}

export default Counter;