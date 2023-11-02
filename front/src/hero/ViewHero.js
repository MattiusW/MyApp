import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'

export default function ViewHero () {

    const [hero, setHero] = useState({
        name:"",
        level:"",
        gold:""
    });

    const {id} = useParams();

    useEffect(()=>{
        loadHero();
    },[]);

    const loadHero = async () => {
        const result = await axios.get(`http://localhost:8080/hero/${id}`);
        setHero(result.data);
    }

  return (
    <div className='container'>
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
          <h2 className='text-center m-4'>Hero details</h2>

          <div className='card'>
            <div className='card-header'>
              Number of create: {hero.id}
              <ul className='list-group list-group-flush'>
                <li className='list-group-item'>
                  <b>Name: </b>
                  {hero.name}
                </li>

                <li className='list-group-item'>
                  <b>Level: </b>
                  {hero.level}
                </li>

                <li className='list-group-item'>
                  <b>Gold: </b>
                  {hero.gold}
                </li>
              </ul>
            </div>
          </div>
          <Link className='btn btn-primary my-2' to={'/'}>
            Back
          </Link>
        </div>
      </div>
    </div>
  )
}
