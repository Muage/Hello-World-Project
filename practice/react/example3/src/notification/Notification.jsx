import React, { Component } from "react";

const styles = {
    wrapper: {
        margin: 8,
        padding: 8,
        display: "flex",
        flexDirection: "row",
        border: "1px solid gray",
        borderRadius: 16
    },
    messageText: {
        color: "black",
        fontSize: 16
    }
}

class Notification extends Component {

    constructor(props) {
        super(props);
        this.state = {};
    }

    // Lifecycle method
    componentDidMount() {
        console.log(`Notification :: ${this.props.id} componentDidMount() called.`);
    }

    componentDidUpdate() {
        console.log(`Notification :: ${this.props.id} componentDidUpdate() called.`);
    }

    componentWillUnmount() {
        console.log(`Notification :: ${this.props.id} componentWillUnmount() called.`);
    }

    render() {
        return (
            <div style={styles.wrapper}>
                <span style={styles.messageText}>{this.props.message}</span>
            </div>
        );
    }

}

export default Notification;