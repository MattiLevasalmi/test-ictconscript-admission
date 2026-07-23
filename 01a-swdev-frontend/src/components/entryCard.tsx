import Card from '@mui/material/Card';
import './entryCard.css';
import type { Entry } from '../types/entryType';

export default function EntryCard(props: Entry) {
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
          <button
            type="button"
            className="button">
            {props.lat}° {props.lon}°
          </button>
        ) : (
          <></>
        )}
      </section>
    </Card>
  );
}
