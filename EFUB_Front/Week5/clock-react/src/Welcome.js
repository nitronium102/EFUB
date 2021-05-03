import React, { Component } from "react";

class Welcome extends Component {
    state = {
        name: "이퍼비"
    }
    render() {
        return (
            < div >
                Hello, <b>{this.state.name}</b>
            </div >
        );
    }
}

export default Welcome;