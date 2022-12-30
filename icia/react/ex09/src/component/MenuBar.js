import React from 'react'
import { Link } from 'react-router-dom'

const MenuBar = () => {
    const style = {
        background: '#4050B5',
        color: '#FFF',
        padding: '20px'
    }

    return (
        <div style={style} className='menubar'>
            <Link to='/'>Home</Link>
            <Link to='/customers'>Customers</Link>
            <Link to='/chart?type=1'>Chart</Link>
            <Link to='/posts'>Posts</Link>
        </div>
    )
}

export default MenuBar
