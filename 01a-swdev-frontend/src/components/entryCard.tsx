import Card from '@mui/material/Card';
import './entryCard.css';
import type { Entry } from '../types/entryType';
import { useState } from 'react';
import Modal from '@mui/material/Modal';
import CoordinateMap from './coordinateMap';

export default function EntryCard(props: Entry) {
  const [modalState, setModalState] = useState<boolean>(false);

  const handleOpen = () => {
    setModalState(true);
  };
  const handleClose = () => {
    setModalState(false);
  };
  return (
    <Card className="entry-card">
      <section id="header">
        <h4>{props.title}</h4>
        <code>#{props.id}</code>
      </section>
      <section id="description">
        <p>{props.body}</p>
      </section>
      <section id="footer">
        <h5>{new Date(props.isoTime).toLocaleString('en-GB')}</h5>
        {props.lat != undefined && props.lon != undefined ? (
          <>
            <button type="button" className="button" onClick={handleOpen}>
              {props.lat}° {props.lon}°
            </button>
            <Modal open={modalState} onClose={handleClose}>
              <CoordinateMap latitude={props.lat} longitude={props.lon} />
            </Modal>
          </>
        ) : (
          <></>
        )}
      </section>
    </Card>
  );
}
