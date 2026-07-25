import Card from '@mui/material/Card';
import './newEntryCard.css';
import type { Entry } from '../types/entryType';
import Close from '@mui/icons-material/Close';
import IconButton from '@mui/material/IconButton';
import { Grid, TextField } from '@mui/material';
import React, { useState } from 'react';
import CoordinateMap from './coordinateMap';

type NewEntryCardProps = {
  addEntry: (newEntry: Entry) => void;
  handleClose: () => void;
};

export default function NewEntryCard(props: NewEntryCardProps) {
  const [formData, setFormData] = useState<Entry>({
    id: '',
    title: '',
    body: '',
    isoTime: ''
  });
  const [coordError, setCoordError] = useState<boolean>(false);

  const handleChange = (
    event: React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>
  ) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleChangeCoords = (
    event: React.ChangeEvent<HTMLTextAreaElement | HTMLInputElement>
  ) => {
    const { name, value } = event.target;
    setCoordError(false);

    if (value === '') {
      setFormData({ ...formData, [name]: undefined });
      return;
    }

    if (!Number.isNaN(Number(value))) {
      setFormData({ ...formData, [name]: Number(Number(value).toFixed(4)) });
    }
  };

  const handleSubmit = (event: React.SyntheticEvent<HTMLFormElement>) => {
    event.preventDefault();
    if ((formData.lon === undefined) != (formData.lat === undefined)) {
      setCoordError(true);
      return;
    }
    props.addEntry(formData);
    props.handleClose();
  };

  return (
    <Card className="new-entry-card">
      <div id="header">
        <h4>Add a new entry</h4>
        <IconButton onClick={props.handleClose}>
          <Close />
        </IconButton>
      </div>
      <form onSubmit={handleSubmit} className="new-entry-form">
        <Grid container spacing={2}>
          <Grid size={6}>
            <TextField
              label="Title"
              name="title"
              fullWidth
              required
              value={formData.title}
              onChange={handleChange}
            />
          </Grid>
          <Grid size={3}>
            <TextField
              label="Latitude"
              name="lat"
              type="number"
              fullWidth
              slotProps={{
                htmlInput: {
                  max: 90,
                  min: -90,
                  step: 'any'
                }
              }}
              value={formData.lat}
              onChange={handleChangeCoords}
            />
          </Grid>
          <Grid size={3}>
            <TextField
              label="Longitude"
              name="lon"
              type="number"
              fullWidth
              slotProps={{
                htmlInput: {
                  max: 180,
                  min: -180,
                  step: 'any'
                }
              }}
              value={formData.lon}
              onChange={handleChangeCoords}
            />
          </Grid>
          <Grid size={6}>
            <TextField
              label="Body"
              name="body"
              multiline
              fullWidth
              required
              rows={3}
              value={formData.body}
              onChange={handleChange}
            />
            <button type="submit" className="submitButton">
              Add Entry
            </button>
          </Grid>
          <Grid size={6}>
            <CoordinateMap
              latitude={formData.lat}
              longitude={formData.lon}
              variant="inline"
            />
          </Grid>
          <Grid size={6}>
            {coordError ? (
              <p className="error">
                Latitude and longitude must either both be filled in or both be
                left blank.
              </p>
            ) : (
              <></>
            )}
          </Grid>
        </Grid>
      </form>
    </Card>
  );
}
